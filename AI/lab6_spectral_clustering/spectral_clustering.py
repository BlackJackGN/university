import numpy as np
from datasets import two_moon_dataset, gaussians_dataset
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt

plt.ion()

def spectral_clustering(data, n_cl, sigma=1., fiedler_solution=False):
    W = np.exp(-np.linalg.norm(data[:, None, :] - data[None, :, :], axis=2) ** 2 / (sigma ** 2))
    np.fill_diagonal(W, 0.0)
    D = np.diag(W.sum(axis=1))
    L = D - W
    _, eigvecs = np.linalg.eigh(L)
    if fiedler_solution:
        return eigvecs[:, 1:n_cl+1]>0
    else:
        return KMeans(n_clusters=n_cl, n_init=10).fit_predict(eigvecs[:, 1:n_cl+1])


def main_spectral_clustering():

    # generate the dataset
    data, cl = two_moon_dataset(n_samples=300, noise=0.1)
    #data, cl = gaussians_dataset(n_gaussian=3, n_points=[100, 100, 70], mus=[[1, 1], [-4, 6], [8, 8]], stds=[[1, 1], [3, 3], [1, 1]])

    # visualize the dataset
    _, ax = plt.subplots(1, 2)
    ax[0].scatter(data[:, 0], data[:, 1], c=cl, s=40)

    # run spectral clustering - tune n_cl and sigma!!!
    labels = spectral_clustering(data, n_cl=2, sigma=0.1)
    #labels = spectral_clustering(data, n_cl=3, sigma=20)

    # visualize results
    ax[1].scatter(data[:, 0], data[:, 1], c=labels, s=40)
    plt.waitforbuttonpress()

if __name__ == "__main__":
    main_spectral_clustering()

from typing import Optional

import matplotlib.pyplot as plt
import numpy as np
from numpy.random import uniform
from cluster import KMeans

class SpectralClustering:
    def __init__(self, n_cl: int, n_init: int = 1, gamma: float = 1.0, verbose: bool = False):
        self.n_cl = n_cl
        self.n_init = n_init
        self.gamma = gamma
        self.verbose = verbose

    def _compute_similarity_matrix(self, X: np.ndarray):
        #compute the similarity matrix using the RBF kernel
        sq_dist=np.sum((X[:,np.newaxis]-X)**2,axis=2)
        return np.exp(-self.gamma * sq_dist)
    
    def _compute_laplacian(self, W: np.ndarray):
        np.fill_diagonal(W, 0)  # azzera la diagonale!
        D = np.diag(W.sum(axis=1))
        return D - W
    
    def _compute_eigenvectors(self, L: np.array):
        #compute the first k eigenvectors of the laplacian
        eigvals, eigvecs = np.linalg.eigh(L)
        return eigvecs[:, 1:self.n_cl+1] # skip the first eigenvector (corresponding to eigenvalue 0)
    
    def fit_predict(self, X: np.ndarray):
        W = self._compute_similarity_matrix(X)
        L = self._compute_laplacian(W)
        eigvecs = self._compute_eigenvectors(L)
        kmeans = KMeans(n_cl=self.n_cl, n_init=self.n_init, verbose=self.verbose)
        return kmeans.fit_predict(eigvecs)
    
from typing import Optional

import matplotlib.pyplot as plt
import numpy as np
from numpy.random import uniform


class KMeans:
    def __init__(self, n_cl: int, n_init: int = 1,
                 initial_centers: Optional[np.ndarray] = None,
                 verbose: bool = False) -> None:
        """
        Parameters
        ----------
        n_cl: int
            number of clusters.
        n_init: int
            number of time the k-means algorithm will be run.
        initial_centers:
            If an ndarray is passed, it should be of shape (n_clusters, n_features)
            and gives the initial centers.
        verbose: bool
            whether or not to plot assignment at each iteration (default is True).
        """

        self.n_cl = n_cl
        self.n_init = n_init
        self.initial_centers = initial_centers
        self.verbose = verbose

    def _init_centers(self, X: np.ndarray, use_samples: bool = False):
        if self.initial_centers is not None:
            return self.initial_centers.copy()
        idx = np.random.choice(X.shape[0], size=self.n_cl, replace=False)
        return X[idx].copy()

    def single_fit_predict(self, X: np.ndarray):
        centers = self._init_centers(X)
        old_assignments = None

        while True:
            # assignment step
            distances = np.linalg.norm(X[:, None, :] - centers[None, :, :], axis=2)
            new_assignments = np.argmin(distances, axis=1)

            # update step (eseguito prima del criterio di arresto)
            for k in range(self.n_cl):
                mask = new_assignments == k
                if np.any(mask):
                    centers[k] = X[mask].mean(axis=0)

            # stopping criterion
            if old_assignments is not None and np.array_equal(old_assignments, new_assignments):
                break
            old_assignments = new_assignments

        return centers, new_assignments

    def compute_cost_function(self, X: np.ndarray, centers: np.ndarray,
                              assignments: np.ndarray):
        cost = 0.0
        for k in range(self.n_cl):
            mask = assignments == k
            if np.any(mask):
                cost += np.sum((X[mask] - centers[k]) ** 2)
        return cost

    def fit_predict(self, X: np.ndarray):
        best_cost = np.inf
        best_centers = None
        best_assignments = None

        for i in range(self.n_init):
            centers, assignments = self.single_fit_predict(X)
            cost = self.compute_cost_function(X, centers, assignments)
            if self.verbose:
                print(f"Init {i}: cost = {cost}")
            if cost < best_cost:
                best_cost = cost
                best_centers = centers
                best_assignments = assignments

        self.cluster_centers_ = best_centers
        return best_assignments

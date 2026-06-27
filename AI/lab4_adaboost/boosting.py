import matplotlib.pyplot as plt
import numpy as np

from utils import cmap

class WeakClassifier:
    """
    Function that models a WeakClassifier based on a simple threshold.
    """

    def __init__(self):

        # initialize a few stuff
        self._dim = None
        self._threshold = None
        self._label_above_split = None

    def fit(self, X: np.ndarray, Y: np.ndarray):
        self._dim = np.random.randint(X.shape[1])
        feature = X[:, self._dim]
        self._threshold = np.random.uniform(feature.min(), feature.max())
        self._label_above_split = np.random.choice([-1, 1])

    def predict(self, X: np.ndarray):
        Y_pred = np.where(X[:, self._dim] > self._threshold,self._label_above_split,-self._label_above_split)
        return Y_pred


class AdaBoostClassifier:
    """
    Function that models a Adaboost classifier
    """

    def __init__(self, n_learners: int, n_max_trials: int = 200):
        """
        Model constructor

        Parameters
        ----------
        n_learners: int
            number of weak classifiers.
        """

        # initialize a few stuff
        self.n_learners = n_learners
        self.learners = []
        self.alphas = np.zeros(shape=n_learners)
        self.n_max_trials = n_max_trials

    def fit(self, X: np.ndarray, Y: np.ndarray, verbose: bool = False):
        n = X.shape[0]
        sample_weights = np.ones(n) / n

        for i in range(self.n_learners):
            error = 1
            while error > 0.5:
                learner = WeakClassifier()
                # campiona n//2 punti secondo i pesi correnti
                subset = np.random.choice(n, n // 2, replace=False, p=sample_weights)
                learner.fit(X[subset], Y[subset])
                # errore pesato e normalizzato calcolato solo sul subset
                Y_pred = learner.predict(X[subset])
                error = np.sum(sample_weights[subset] * (Y_pred != Y[subset])) \
                        / np.sum(sample_weights[subset])

            alpha = 0.5 * np.log((1 - error) / (error + 1e-10))
            self.learners.append(learner)
            self.alphas[i] = alpha

            # aggiorna i pesi su tutto il dataset e rinormalizza
            Y_pred_all = learner.predict(X)
            sample_weights *= np.exp(-alpha * Y * Y_pred_all)
            sample_weights /= np.sum(sample_weights)

    def predict(self, X: np.ndarray):
        scores = np.zeros(X.shape[0])
        for alpha, learner in zip(self.alphas, self.learners):
            scores += alpha * learner.predict(X)
        return np.sign(scores)


    def _plot(self, X: np.ndarray, y_pred: np.ndarray, weights: np.ndarray,
              learner: WeakClassifier, iteration: int):

        # plot
        plt.clf()
        plt.scatter(X[:, 0], X[:, 1], c=y_pred, s=weights * 50000,
                    cmap=cmap, edgecolors='k')

        M1, m1 = np.max(X[:, 1]), np.min(X[:, 1])
        M0, m0 = np.max(X[:, 0]), np.min(X[:, 0])

        cur_split = learner._threshold
        if learner._dim == 0:
            plt.plot([cur_split, cur_split], [m1, M1], 'k-', lw=5)
        else:
            plt.plot([m0, M0], [cur_split, cur_split], 'k-', lw=5)
        plt.xlim([m0, M0])
        plt.ylim([m1, M1])
        plt.xticks([])
        plt.yticks([])
        plt.title('Iteration: {:04d}'.format(iteration))
        plt.waitforbuttonpress(timeout=0.1)

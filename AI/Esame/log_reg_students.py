import numpy as np


eps = np.finfo(float).eps


def sigmoid(x):

    return 1.0 / (1.0 + np.exp(-x))


def loss(y_true, y_pred):
    
    return - np.mean(y_true * np.log(y_pred + eps) + (1 - y_true) * np.log(1 - y_pred + eps), axis=0)


def dloss_dw(y_true, y_pred, X):

    N = X.shape[0]

    return - X.T @ (y_true - y_pred) / N


class LogisticRegression:
    """ Models a logistic regression classifier. """

    def __init__(self):
        """ Constructor method """

        # weights placeholder
        self._w = None

    def fit_gd(self, X, Y, n_epochs, learning_rate, verbose=False):
        """
        IMPLEMENT
        """

        n_samples, n_features = X.shape

        # weight initialization
        self._w = np.random.randn(n_features) * 0.001

        for e in range(n_epochs):

            # forward pass: compute predicted probabilities
            y_pred = sigmoid(X @ self._w)

            # current loss
            L = loss(Y, y_pred)

            if verbose and e % 500 == 0:
                print(f'Epoch {e:4d}: loss={L}')

            # gradient of the loss w.r.t. the weights
            grad = dloss_dw(Y, y_pred, X)

            # gradient descent update
            self._w -= learning_rate * grad


    def predict(self, X):
        """
        IMPLEMENT
        """
        # predicted probabilities, then threshold at 0.5
        y_pred = sigmoid(X @ self._w)
        return (y_pred >= 0.5).astype(int)

import numpy as np

from datasets import gaussians_dataset
from log_reg_students import LogisticRegression

np.random.seed(191090)


def main():
    """ Main function """

    # sample dataset
    x_train, y_train, x_test, y_test = gaussians_dataset(2, [100, 150], [[1, 3], [-4, 8]], [[2, 3], [4, 1]])
    # create model
    logistic_reg = LogisticRegression()
    # train
    logistic_reg.fit_gd(x_train, y_train, n_epochs=10000, learning_rate=0.01, verbose=True)
    # test
    predictions = logistic_reg.predict(x_test)
    
    accuracy = float(np.sum(predictions == y_test)) / y_test.shape[0]
    print(f'Test accuracy: {accuracy}')
    print("Saving model weights to weights.npy...")
    np.save('weights.npy', logistic_reg._w)

# entry point
if __name__ == '__main__':
    main()

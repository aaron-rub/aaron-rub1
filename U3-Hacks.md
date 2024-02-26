# Connecting FRQ Concepts to a Banking/Savings App Project

## FRQ 1 (Arrays, ArrayLists, & 2D Arrays)

In the banking app, visualizing savings over time is crucial. Similar to FRQ 1's 2D arrays handling, we use a method in our `SavingsController` class to prep data for graph plotting:

```java
private List<List<Double>> prepareSavingsData(String userId) {
    List<List<Double>> savingsData = new ArrayList<>();
    for (SavingsRecord record : fetchedRecords) {
        List<Double> dataPoint = new ArrayList<>();
        dataPoint.add((double) record.getMonth());
        dataPoint.add(record.getAmount());
        savingsData.add(dataPoint);
    }
    return savingsData;
}
```

This method mirrors the row sums calculation, structuring savings data for graphing monthly savings.

## FRQ 2 (Classes)
For goal prediction, similar to the HiddenWord class, we create a GoalPredictor class to match user input against possible saving goals:

```java
public class GoalPredictor {
    private List<String> possibleGoals;

    public GoalPredictor() {
        this.possibleGoals = Arrays.asList("vacation", "car", "home", "education");
    }

    public String getHint(String userInput) {
        for (String goal : possibleGoals) {
            if (goal.startsWith(userInput)) {
                return goal;
            }
        }
        return "No match found";
    }
}
```

This class aids in financial planning by predicting saving goals based on user input.

## FRQ 3 (2D Arrays + Method and Control Structures)
Optimizing transaction storage is akin to sparse array manipulation. We use a method in TransactionOptimizer to remove redundant transactions and compact the data:
```java
public void optimizeTransactions(List<Transaction> transactions) {
    transactions.removeIf(t -> t.isRedundant());
    compactTransactions(transactions);
}
```

This method, inspired by sparse array handling, filters and compacts transaction data for efficiency.

## FRQ 4 (Interfaces, Methods, & Control Structures)
Interfaces like GoalManager define interactions with different saving goals. An implementation for monthly goals might look like this:

```java
public class MonthlyGoalManager implements GoalManager {
    @Override
    public boolean checkGoalCompletion(User user, String goalType) {
        return hasMetMonthlyGoal(user);
    }
}
```

This setup, echoing the NumberGroup interface from FRQ 4, allows for flexible and efficient management of various financial goals, showcasing the power of abstraction and interfaces.

By applying these FRQ insights, we enhance the banking app's functionality, making it not only more organized but also adaptable to diverse user needs.
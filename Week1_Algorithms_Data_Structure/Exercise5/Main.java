class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", taskName='" + taskName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    // Add a task to the end of the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by taskId
    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.taskId == taskId) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();
        
        taskList.addTask(new Task(1, "T 1", "Coding"));
        taskList.addTask(new Task(2, "T 2", "Cooking"));
        taskList.addTask(new Task(3, "T 3", "Studying"));
        
        System.out.println("Traversing tasks:");
        taskList.traverseTasks();
        
        System.out.println("\nSearching for task with ID 3:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }
        
        System.out.println("\nDeleting task with ID 1:");
        taskList.deleteTask(2);
        
        System.out.println("\nTraversing tasks after deletion:");
        taskList.traverseTasks();
    }
}

// OUTPUT

// Traversing tasks:
// Task{taskId=1, taskName='T 1', status='Coding'}
// Task{taskId=2, taskName='T 2', status='Cooking'}
// Task{taskId=3, taskName='T 3', status='Studying'}

// Searching for task with ID 3:
// Task{taskId=2, taskName='T 2', status='Cooking'}

// Deleting task with ID 1:

// Traversing tasks after deletion:
// Task{taskId=1, taskName='T 1', status='Coding'}
// Task{taskId=3, taskName='T 3', status='Studying'}
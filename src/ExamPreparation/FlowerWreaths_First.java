package ExamPreparation;

import java.util.*;

public class FlowerWreaths_First {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[] secondInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();

        Arrays.stream(firstInput).forEach(rosesQueue::push);
        Arrays.stream(secondInput).forEach(liliesStack::offer);
        List<Integer> store = new ArrayList<>();
        int wreathCount = 0;

        while (!rosesQueue.isEmpty() && !liliesStack.isEmpty()) {
            int lastLillie = liliesStack.peek();
            int firstRose = rosesQueue.peek();

            if (lastLillie + firstRose == 15) {
                wreathCount++;
                liliesStack.poll();
                rosesQueue.pop();
            } else if (lastLillie + firstRose > 15) {
                int decreasedByTwo = liliesStack.poll();
                decreasedByTwo -= 2;
                liliesStack.push(decreasedByTwo);
            } else {
                store.add(liliesStack.poll());
                store.add(rosesQueue.pop());
            }

        }
        int storeSum = 0;
        for (Integer integer : store) {
            storeSum += integer;
        }
        storeSum /= 15;
        wreathCount += storeSum;

        if (wreathCount >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreathCount + " wreaths!");
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreathCount);
        }

    }
}
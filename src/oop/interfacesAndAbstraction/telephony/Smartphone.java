package oop.interfacesAndAbstraction.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();

        for (String url : urls) {
            boolean hasDigit = false;
            for (int i = 0; i < url.length() - 1; i++) {
                if (Character.isDigit(url.charAt(i))) {
                    hasDigit = true;
                    break;
                }
            }

            if (hasDigit) {
                sb.append("Invalid URL!\n");
            } else {
                sb.append("Browsing: ").append(url).append("!\n");
            }
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();

        for (String number : numbers) {
            boolean isDigit = true;
            for (int i = 0; i < number.length() - 1; i++) {
                if (!Character.isDigit(number.charAt(i))) {
                    isDigit = false;
                    break;
                }
            }
            if (!isDigit) {
                sb.append("Invalid number!\n");
            } else {
                sb.append("Calling... ").append(number).append("\n");
            }

        }

        return sb.toString();
    }
}

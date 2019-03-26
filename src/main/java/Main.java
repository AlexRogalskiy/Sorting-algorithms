import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        init();
    }

    private static void shakeSort(int[] values) {

        long date1 = new Date().getTime();

        boolean end = false;

        int step = 1;

        while (!end)
        {
            end = true;

            for (int i = 1; i < values.length; i++)
            {
                int now, next;
                now = values[i-1];
                next = values[i];

                if(now > next)
                {
                    values[i] = now;
                    values[i-1] = next;

                    end = false;

                    step++;
                }
            }

            for (int w = values.length - 1; w > 0; w--)
            {
                int now, next;
                now = values[w-1];
                next = values[w];

                if(now > next)
                {
                    values[w] = now;
                    values[w-1] = next;

                    end = false;

                    step++;
                }
            }
        }

        long date2 = new Date().getTime();

        System.out.println("After sorting: " + Arrays.toString(values));
        System.out.println(step + " steps");

        System.out.println("It took us: " + (date2 - date1) + " milliseconds");

        // to sort 50000 integers it takes 2.9 seconds
    }

    private static void init()
    {
        int[] values = new int[50000];

        Random random = new Random();

        for (int i = 0; i < values.length; values[i++] = random.nextInt(5000));

        System.out.println("Before sorting: " + Arrays.toString(values));

        shakeSort(values);
    }

    private static void insertionSort(int[] values)
    {
        long date1 = new Date().getTime();

        long step = 1;

        int now, next;

        for (int i = 1; i < values.length; i++)
        {
            now = values[i - 1];
            next = values[i];

            if(now > next)
            {
                values[i] = now;
                values[i - 1] = next;
                i = 0;
            }

            step++;
        }

        System.out.println("Step " + step + " : " + Arrays.toString(values));

        long date2 = new Date().getTime();

        System.out.println("It took us: " + (date2 - date1) + " milliseconds");

        // to sort 15000 integers it takes 7.2 minutes
    }

    private static void bubbleSort(int[] values)
    {
        int step = 1;

        long date1 = new Date().getTime();

        int now, next;

        for (int i = 1; i < values.length; i++)
        {
            for (int q = 0; q < values.length - i; q++)
            {
                now = values[q];
                next = values[q + 1];

                if(now > next)
                {
                    values[q] = next;
                    values[q + 1] = now;
                }

                step++;
            }
        }

        long date2 = new Date().getTime();
        System.out.println("It took us: " + (date2 - date1) + " milliseconds");
        System.out.println("Step " + step + " : " + Arrays.toString(values));

        // to sort 50000 integers it takes 5.5 seconds
    }
}
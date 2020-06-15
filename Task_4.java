import java.util.LinkedList;
import java.util.List;

public class Task_4 {

    //1
    //Бесси работает над сочинением для своего класса писателей. Поскольку ее почерк довольно плох, она
    //решает напечатать эссе с помощью текстового процессора.Эссе содержит N слов (1≤N≤100), разделенных пробелами. 
    //Каждое слово имеет длину от 1 до 15 символов включительно и состоит только из прописных или
    //строчных букв. Согласно инструкции к заданию, эссе должно быть отформатировано очень специфическим образом: 
    //каждая строка должна содержать не более K (1≤K≤80) символов, не считая пробелов. К счастью, текстовый
    //процессор Бесси может справиться с этим требованием, используя следующую стратегию:
    //– Если Бесси набирает Слово, и это слово может поместиться в текущей строке, поместите его в эту строку.
    //В противном случае поместите слово на следующую строку и продолжайте добавлять к этой строке. 
    //Конечно, последовательные слова в одной строке все равно должны быть разделены одним пробелом. 
    //В конце любой строки не должно быть места.
    //– К сожалению, текстовый процессор Бесси только что сломался. 
    //Пожалуйста,помогите ей правильно оформить свое эссе!
    //Вам будут даны n, k и строка 

    public static List<String> BessieEssay(String essay, int wordsNumber, int lineLength)
    {
        String[] words = essay.split(" ");
        List<String> result = new LinkedList<String>();
        int remaining = lineLength;
        String str = "";
        for (String word : words)
        {
            if (remaining >= word.length())
            {
                str += word;
                remaining -= word.length();
            }
            else
            {
                result.add(str);
                str = word;
                remaining = lineLength - word.length();
            }
        }
        result.add(str);
        return result;
    }

    //2
    //Напишите функцию, которая группирует строку в кластер скобок. 
    //Каждый кластер должен быть сбалансирован. 

    public static List<String> Split(String brackets)
    {
        List<String> result = new LinkedList<String>();
        int count = 0;
        String buffer = "";
        for(int i = 0; i < brackets.length(); i++)
        {
            if (brackets.charAt(i) == '(')
                count++;
            else if (brackets.charAt(i) == ')')
                count--;

            buffer += brackets.charAt(i);
            if (count == 0)
            {
                result.add(buffer);
                buffer = "";
            }
        }

        return result;
    }


    //3
    //Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет
    //одну строку и преобразует ее либо в camelCase, либо в snake_case. 

    public static String toCamelCase(String str)
    {
        String[] parts = str.split("_");

        return  parts[0] + parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1);
    }

    public static String toSnakeCase(String str)
    {
        String first = "", second = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == Character.toUpperCase(str.charAt(i)))
            {
                first = str.substring(0, i);
                second = str.substring(i);
                break;
            }
        }

        //4
        //Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную с сверхурочной работой.
        //Работа с 9 до 5: обычные часы работы
        //После 5 вечера это сверхурочная работа
        //Ваша функция получает массив с 4 значениями:
        //– Начало рабочего дня, в десятичном формате, (24-часовая дневная нотация)
        //– Конец рабочего дня. (Тот же формат)
        //– Почасовая ставка
        //– Множитель сверхурочных работ
        //Ваша функция должна возвращать:
        //$ + заработанные в тот день (округлены до ближайшей сотой) 


        public static double overTime(double start, double end, double rate, double modifier)
        {
            if (start <= 17.0)
            {
                if (end > 17.0)
                {
                    return (17.0 - start) * rate + (end - 17.0) * rate * modifier;
                }
                else
                {
                    return (end - start) * rate;
                }
            }
            else
            {
                return (end - start) * rate * modifier;
            }
        }

        //5
        //Индекс массы тела (ИМТ) определяется путем измерения вашего веса в
        //килограммах и деления на квадрат вашего роста в метрах. Категории ИМТ таковы:
        //Недостаточный вес: <18,5
        //Нормальный вес: 18.5-24.9
        //Избыточный вес: 25 и более
        //Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах,
        //метрах или дюймах) и возвращать ИМТ и связанную с ним категорию. 
        //Округлите ИМТ до ближайшей десятой. 

        public static String BMI(String weight, String height)
        {
            String[] Weight = weight.split(" ");
            String[] Height = height.split(" ");

            double ParsedWeight = Double.parseDouble(Weight[0]);
            double ParsedHeight = Double.parseDouble(Height[0]);

            final double kilosToPounds = 2.20462;
            final double metersToInches = 39.3701;

            if (Weight[1].equals("pounds"))
                ParsedWeight /= kilosToPounds;
            if (Height[1].equals("inches"))
                ParsedHeight /= metersToInches;

            double result = ParsedWeight / ParsedHeight / ParsedHeight;
            result = (double)(java.lang.Math.round(result * 10 )) / 10;

            String category = "";

            if (result < 18.5)
                category = "Underweight";
            else if (result < 25)
                category = "Normal weight";
            else
                category = "Overweight";

            return Double.toString(result) + " " + category;
        }



        //6
        //Создайте функцию, которая принимает число и возвращает его мультипликативное
        //постоянство, которое представляет собой количество раз, которое вы должны
        //умножать цифры в num, пока не достигнете одной цифры. 


        public static int bugger(int num)
        {
            int count = 1;

            while (Integer.toString(multiplyDigits(num)).length() != 1)
            {
                num = multiplyDigits(num);
                count++;
            }


            return count;
        }

        public static int multiplyDigits(int num)
        {
            if (num == 0)
                return 0;
            int result = 1;
            while (num > 0)
            {
                result *= num % 10;
                num /= 10;
            }

            return result;
        }


        //7
        //Напишите функцию, которая преобразует строку в звездную стенографию. 
        //Если символ повторяется n раз, преобразуйте его в символ*n. 

        public static String toShortHand(String str)
        {
            int count = 1;
            String result = "";

            for(int i = 0; i < str.length() - 1; i++)
            {
                if (str.charAt(i) == str.charAt(i + 1))
                    count++;
                else
                {
                    if (count > 1)
                    {
                        result += str.charAt(i) + "*" + Integer.toString(count);
                        count = 1;
                    }
                    else {
                        result += str.charAt(i);
                    }
                }
            }
            if (str.charAt(str.length() - 1) == str.charAt(str.length() - 2))
                result += str.charAt(str.length() - 1) + "*" + Integer.toString(count);
            else result += str.charAt(str.length() - 1);

            return result;
        }

        //8
        //Создайте функцию, которая возвращает true, если две строки рифмуются, и false в противном случае. 
        //Для целей этого упражнения две строки рифмуются, если
        //последнее слово из каждого предложения содержит одни и те же гласные. 


        public static boolean doesRhyme(String str1, String str2)
        {
            String[] words1 = str1.split(" ");
            String[] words2 = str2.split(" ");

            return takeVowels(words1[words1.length - 1]).equals(takeVowels(words2[words2.length - 1]));
        }

        public static String takeVowels(String str)
        {
            String vowels = "AEIOUaeiou";
            String result = "";

            for (int i = 0; i < str.length(); i++)
            {
                if (vowels.contains(Character.toString(str.charAt(i))))
                    result += str.charAt(i);
            }
            return result;
        }

        //9
        //Создайте функцию, которая принимает два целых числа и возвращает true, если
        //число повторяется три раза подряд в любом месте в num1 и то же самое число
        //повторяется два раза подряд в num2. 

        public static boolean trouble(long num1, long num2)
        {
            for (int i = 1; i < 10; i++)
            {
                if (Long.toString(num1).contains(Integer.toString(i) + Integer.toString(i) + Integer.toString(i)))
                {
                    if (Long.toString(num2).contains(Integer.toString(i) + Integer.toString(i)))
                        return true;
                }

            }
            return false;
        }

        //10
        //Предположим, что пара одинаковых символов служит концами книги для всех
        //символов между ними. Напишите функцию, которая возвращает общее количество
        //уникальных символов (книг, так сказать) между всеми парами концов книги.

        public static int countUniqueBooks(String str, String separator)
        {
            String special = "[$&+,:;=?@#|'<>.-^*()%!]";
            if (special.contains(separator))
                separator = Character.toString('\\') + separator;
            String[] books = str.split(separator);
            int sum = 0;

            for (int i = 1; i < books.length; i += 2)
            {
                sum += countUniqueChars(books[i]);
            }
            return sum;
        }

        private static int countUniqueChars(String str)
        {
            int result = 0;
            for (int i = 0; i < str.length(); i++)
            {
                if (i == str.lastIndexOf(str.charAt(i)))
                    result++;
            }
            return result;
        }


        public static void main(String[] args) {
        System.out.println("№1: " + BessieEssay("Test essay", 2, 6));
        System.out.println("№2: " + Split("((()))(())()()(()())"));
        System.out.println("№3: " + toCamelCase("hello_edabit"));
        System.out.println("№3: " + toSnakeCase("helloEdabit"));
        System.out.println("№4: " + overTime(16, 18, 30, 1.8));
        System.out.println("№5: " + BMI("205 pounds", "73 inches"));
        System.out.println("№6: " + bugger(999));
        System.out.println("№7: " + toShortHand("abbccc"));
        System.out.println("№8: " + doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println("№9: " + trouble(451999277, 411777899));
        System.out.println("№10: " + countUniqueBooks("$AA$BBCATT$C$$B$", "$"));

        }



    }

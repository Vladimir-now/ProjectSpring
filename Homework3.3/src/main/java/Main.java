import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Scanner;

public class Main {
 /**
  *  1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
  *  2.Последовательно сшить 5 файлов в один (файлы примерно 100 байт). Может пригодиться следующая конструкция:
  *  ArrayList<InputStream> al = new ArrayList<>(); ... Enumeration<InputStream> e = Collections.enumeration(al);
  *  3.Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
  *  Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
  *  Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
  *  4.Сделать клиен-серверное приложение. Передать по сети сеарилизованный объект.
 */

    public static void main(String[] args) throws IOException {

//        File file = new File("directory");
//        file.mkdir();

//        String[] files = file.list(new FilenameFilter() {
//            public boolean accept(File dir, String name) {
//                return name.startsWith("1");
//            }
//        });
//
//        for (String o : files) {
//            System.out.println(o);
//        }
//        File fileNew = new File("directory/1.txt");
//        try {
//            fileNew.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        long t = System.currentTimeMillis();
//        try (FileInputStream in = new FileInputStream("directory/forHW.txt")) {
//
//            byte[] arr = new byte[512];
//
//            int x;
//            while ((x = in.read(arr)) != -1) {
//                System.out.print(new String(arr, 0, x));
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - t);


//        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("directory/forHW.txt"), "UTF-8")) {
//            int x;
//            while ((x = isr.read()) != -1) {
//                System.out.print((char) x);
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        long t = System.currentTimeMillis();
//
//        BufferedReader br = null;
//        FileReader fr = null;
//
//        try {
//            fr = new FileReader("directory/forHW.txt");
//            br = new BufferedReader(fr);
//
//            String currentLine;
//
//            while ((currentLine = br.readLine()) != null) {
//                System.out.println(currentLine);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//                try {
//                    if (br != null) {
//                        br.close();
//                    }
//                    if (fr != null) {
//                        fr.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//        }
//
//        System.out.println(System.currentTimeMillis() - t);


//        PipedInputStream in = null;
//        PipedOutputStream out = null;
//
//        try {
//            in = new PipedInputStream();
//            out = new PipedOutputStream();
//
//            out.connect(in);
//            for (int i = 0; i < 100; i++) {
//                out.write(i);
//            }
//
//            int x;
//            while ((x = in.read()) != -1) {
//                System.out.println(x);
//            }
//            in.close();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            in.close();
//            out.close();
//        }


//        ArrayList<InputStream> ali = new ArrayList<>();
//        ali.add(new FileInputStream("directory/1.txt"));
//        ali.add(new FileInputStream("directory/2.txt"));
//        ali.add(new FileInputStream("directory/3.txt"));
//        ali.add(new FileInputStream("directory/4.txt"));
//
//        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(ali));
//
//        int x;
//        while ((x = sis.read()) != -1) {
//            System.out.print((char) x);
//        }


//        try (RandomAccessFile raf = new RandomAccessFile("directory/forHW.txt", "r")) {
//            raf.seek(2);
//            System.out.println((char) raf.read());
//        }



//        Student student = new Student(1, "Bob");
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stud.ser"));
//        oos.writeObject(student);
//        oos.close();

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"));
//        Student s2 = (Student) ois.readObject();
//        ois.close();
//        s2.info();


/**
 *      Task 1
 */
//        long t = System.currentTimeMillis();
//        readFile("directory/forHW.txt");
//        System.out.println(System.currentTimeMillis() - t);
/**
 *      Task 2
 */
//        ArrayList<InputStream> al = new ArrayList<>();
//        al.add(new FileInputStream("directory/1.txt"));
//        al.add(new FileInputStream("directory/2.txt"));
//        al.add(new FileInputStream("directory/3.txt"));
//        al.add(new FileInputStream("directory/4.txt"));
//
//        stitchFiles(al, "directory", "newFile");

/**
 *      Task 3
 */
        readPage("directory/forHW10mb.txt");

    }

//    1.Прочитать файл (около 50 байт) в байтовый массив и вывести этот массив в консоль;
    static void readFile(String folderPath) {
        try (FileInputStream fis = new FileInputStream(folderPath)) {
            byte[] page = new byte[1024];
            int x;
            while((x = fis.read(page)) != -1) {
                System.out.println(new String(page, 0 , x));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    2.Последовательно сшить 5 файлов в один (файлы примерно 100 байт).
    static void stitchFiles (ArrayList<InputStream> arrTxtFiles, String folderPath, String fileName) throws IOException {
        SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(arrTxtFiles));
        FileOutputStream newFile = new FileOutputStream(folderPath + "/" + fileName);
        int x;
        while ((x = sis.read()) != -1) {
            newFile.write(x);
        }
        sis.close();
        newFile.close();
    }


//     3.Написать консольное приложение, которое умеет постранично читать текстовые файлы (размером > 10 mb).
//       *  Вводим страницу (за страницу можно принять 1800 символов), программа выводит ее в консоль.
//       *  Контролируем время выполнения: программа не должна загружаться дольше 10 секунд, а чтение – занимать свыше 5 секунд.
    static void readPage (String folderPath) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter the page number:");
            int pageNumber = scanner.nextInt();
            while (pageNumber <= 0) {
                System.out.println("This page was not found.\nTry again");
                pageNumber = scanner.nextInt();
                if (pageNumber > 0) {
                    break;
                }
            }
            try (RandomAccessFile raf = new RandomAccessFile(folderPath, "r")) {
                long t = System.currentTimeMillis();
                System.out.println("Page number is: " + pageNumber);
                for (int i = 1800 * (pageNumber - 1); i < 1800 * pageNumber; i++) {
                    raf.seek(i + 1);
                    System.out.print((char) raf.read());
                    if (raf.read() == -1) {
                        System.out.println("The text ended");
                        break;
                    }
                }
                System.out.println("\nPage load time: " + (System.currentTimeMillis() - t));
                System.out.println("If you want to finish reading enter: /end \nIf not enter any value:");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while (!scanner.next().equalsIgnoreCase("/end"));
        scanner.close();
    }

}

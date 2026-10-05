import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class StatistikNilai {
    static final int SELESAI = -1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();
        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;

        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                break;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("   Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);

        } while (true);

        if (daftar.isEmpty()) {
            System.out.println();
            System.out.println("Tidak ada nilai yang tersimpan.");
            input.close();
            return;
        }

        System.out.println();
        System.out.println("Nilai tersimpan : " + daftar);

        int jumlah = daftar.size();

        System.out.println("Jumlah         : " + jumlah);

        int total = 0;

        for (int i = 0; i < daftar.size(); i++) {
            total += daftar.get(i);
        }

        double rataRata = (double) total / jumlah;

        System.out.printf("Rata-rata      : %.2f%n", rataRata);

        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);

        for (int i = 1; i < daftar.size(); i++) {
            int nilaiSekarang = daftar.get(i);

            if (nilaiSekarang > tertinggi) {
                tertinggi = nilaiSekarang;
            }

            if (nilaiSekarang < terendah) {
                terendah = nilaiSekarang;
            }
        }

        System.out.println("Tertinggi      : " + tertinggi);
        System.out.println("Terendah       : " + terendah);

        int diAtasRataRata = 0;

        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i) > rataRata) {
                diAtasRataRata++;
            }
        }

        System.out.println("Di atas rata2  : " + diAtasRataRata + " orang");

        int[] jumlahGrade = new int[5];

        for (int i = 0; i < daftar.size(); i++) {
            int nilaiSekarang = daftar.get(i);

            if (nilaiSekarang >= 80) {
                jumlahGrade[0]++;
            } else if (nilaiSekarang >= 70) {
                jumlahGrade[1]++;
            } else if (nilaiSekarang >= 60) {
                jumlahGrade[2]++;
            } else if (nilaiSekarang >= 50) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }

        System.out.print("Distribusi     : ");

        char[] grade = {'A', 'B', 'C', 'D', 'E'};

        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(grade[i] + "=" + jumlahGrade[i]);

            if (i < jumlahGrade.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        System.out.println("Terurut        : " + terurut);

        System.out.println("Urutan asli    : " + daftar);

        input.close();
    }
}
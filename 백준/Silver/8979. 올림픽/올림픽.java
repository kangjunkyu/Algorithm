import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Olimpic implements Comparable<Olimpic> {
	int contry;
	int gold;
	int silver;
	int bronze;
	int ranking;

	Olimpic(int contry, int gold, int silver, int bronze, int ranking) {
		this.contry = contry;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
		this.ranking = ranking;
	}

	@Override
	public int compareTo(Olimpic o) {
		if (this.gold == o.gold) {
			if (this.silver == o.silver) {
				return o.bronze - this.bronze;
			} else {
				return o.silver - this.silver;
			}
		} else {
			return o.gold - this.gold;
		}
	}
}

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		ArrayList<Olimpic> contryList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int contry = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			contryList.add(new Olimpic(contry, gold, silver, bronze, 0));
		}

		Collections.sort(contryList);

		contryList.get(0).ranking = 1;

		for (int i = 1; i < N; i++) {
			Olimpic tmpContry = contryList.get(i - 1);
			int tmpGold = tmpContry.gold;
			int tmpSilver = tmpContry.silver;
			int tmpBronze = tmpContry.bronze;
			Olimpic nowContry = contryList.get(i);

			if (tmpGold == nowContry.gold && tmpSilver == nowContry.silver && tmpBronze == nowContry.bronze) {
				nowContry.ranking = tmpContry.ranking;
			} else {
				nowContry.ranking = tmpContry.ranking + 1;
			}
		}

		int findRank = 0;

		for (Olimpic search : contryList) {
			if (search.contry == K) {
				findRank = search.ranking;
			}
		}
		System.out.println(findRank);
	}
}
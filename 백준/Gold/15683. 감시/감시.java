import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Camera {
		int x;
		int y;
		int num;

		public Camera(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}

	}

	static int N, M, howMany;
	static int[][] map, copymap;
	static boolean[][] check;
	static int[] directions;
	static int min = 987654321;

	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 }; // 상우하좌
	static List<Camera> cam;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		check = new boolean[N][M];

		cam = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] != 0 && map[i][j] < 6) {
					cam.add(new Camera(i, j, map[i][j]));
				}
			}
		}

		directions = new int[cam.size()];
		howMany = cam.size();

		dfs(0);

		System.out.println(min);
	}

	static void copyBoard() {
		copymap = new int[N][M];

		for (int i = 0; i < N; i++) {
			System.arraycopy(map[i], 0, copymap[i], 0, M);
		}
	}

	static void dfs(int depth) {
		if (depth == howMany) {
			copyBoard();

			for (int i = 0; i < howMany; i++) {
				int d = directions[i];
				Camera camera = cam.get(i);

				observeCctv(d, camera);
			}

			check();
		} else {
			for (int i = 0; i < 4; i++) {
				directions[depth] = i;
				dfs(depth + 1);
			}
		}

	}

//	static void rec(Camera start) {
//		cam.add(start);
//
//		// 상우하좌
//		while (!cam.isEmpty()) {
//			Camera now = cam.poll();
//
//			if (now.num == 1) {
//				for (int d = 0; d < 4; d++) {
//					int nx = now.x + dr[d];
//					int ny = now.y + dc[d];
//				}
//
//			} else if (now.num == 2) {
//				for (int d = 0; d < 4; d++) {
//					int nx = now.x + dr[d];
//					int ny = now.y + dc[d];
//				}
//
//			} else if (now.num == 3) {
//				for (int d = 0; d < 4; d++) {
//					int nx = now.x + dr[d];
//					int ny = now.y + dc[d];
//				}
//
//			} else if (now.num == 4) {
//				for (int d = 0; d < 4; d++) {
//					int nx = now.x + dr[d];
//					int ny = now.y + dc[d];
//				}
//
//			} else if (now.num == 5) {
//				for (int d = 0; d < 4; d++) {
//					int nx = now.x + dr[d];
//					int ny = now.y + dc[d];
//				}
//
//			}
//		}
//	}
	static void check() {
		int count = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copymap[i][j] == 0) {
					count++;
				}
			}
		}

		min = Math.min(min, count);
	}

	static void observeCctv(int d, Camera camera) {
		if (camera.num == 1) {
			observeDir(camera, d);
		} else if (camera.num == 2) {
			if (d == 0 || d == 2) {
				observeDir(camera, 0);
				observeDir(camera, 2);
			} else {
				observeDir(camera, 1);
				observeDir(camera, 3);
			}
		} else if (camera.num == 3) {
			if (d == 3) {
				observeDir(camera, 0);
				observeDir(camera, 3);
			} else {
				observeDir(camera, d);
				observeDir(camera, d + 1);
			}
		} else if (camera.num == 4) {
			if (d == 0) {
				observeDir(camera, 0);
				observeDir(camera, 1);
				observeDir(camera, 3);
			} else if (d == 1) {
				observeDir(camera, 0);
				observeDir(camera, 1);
				observeDir(camera, 2);
			} else if (d == 2) {
				observeDir(camera, 1);
				observeDir(camera, 2);
				observeDir(camera, 3);
			} else if (d == 3) {
				observeDir(camera, 2);
				observeDir(camera, 3);
				observeDir(camera, 0);
			}
		} else if (camera.num == 5) {
			observeDir(camera, 0);
			observeDir(camera, 1);
			observeDir(camera, 2);
			observeDir(camera, 3);
		}
	}

	static void observeDir(Camera camera, int direction) {
		int nx = camera.x + dr[direction];
		int ny = camera.y + dc[direction];

		while (nx >= 0 && nx < N && ny >= 0 && ny < M && copymap[nx][ny] != 6) {
			copymap[nx][ny] = -1;

			nx += dr[direction];
			ny += dc[direction];
		}

	}
}
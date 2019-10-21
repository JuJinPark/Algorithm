package main.java.ETC;
import java.io.*;
import java.util.*;

public class ByeFineDust {
	 public static StringTokenizer stk;
	    public static Cleaner[] cleaner_pos = new Cleaner[2];   //공기청정기 위치 저장
	    public static int r, c, t;
	    public static int[][] map;
	    public static int[] dx = {1, -1, 0, 0};
	    public static int[] dy = {0, 0, 1, -1};
	 
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        stk = new StringTokenizer(br.readLine());
	        r = Integer.parseInt(stk.nextToken());
	        c = Integer.parseInt(stk.nextToken());
	        t = Integer.parseInt(stk.nextToken());
	        map = new int[r][c];
	        int idx = 0;
	        for (int i = 0; i < r; i++) {
	            stk = new StringTokenizer(br.readLine());
	            for (int j = 0; j < c; j++) {
	                map[i][j] = Integer.parseInt(stk.nextToken());
	                if (map[i][j] == -1) {
	                    cleaner_pos[idx++] = new Cleaner(i, j);
	                }
	            }
	        }
	        for (int i = 0; i < t; i++) {
	            spreadStart(new int[r][c]);
	            cleanerStart(new int[r][c]);
	        }
	        getAns();
	    }
	 
	    public static void spreadStart(int[][] nmap) {
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
                nmap[i][j] += map[i][j];
	                if (map[i][j] < 5) continue;
	                int spreadCnt = map[i][j] / 5;
	                for (int k = 0; k < 4; k++) {
	                    int ny = i + dy[k];
	                    int nx = j + dx[k];
	                    //해당 맵에 퍼트릴 수 있는지 확인
	                    if (ny >= 0 && ny < r && nx >= 0 && nx < c && map[ny][nx] != -1) {
	                        nmap[i][j] -= spreadCnt;
	                        nmap[ny][nx] += spreadCnt;
	                    }
	                }
	            }
	        }
	        
	        map=nmap;
//	        spreadCopy(nmap);
	    }
	 
	    public static void cleanerStart(int[][] nmap) {
	        for (int idx = 0; idx < 2; idx++) {
	            Cleaner curr = cleaner_pos[idx];
	            int ny = curr.r;
	            int nx = curr.c + 1;
	            //오른쪽으로 끝까지
	            while (nx < c - 1) {
	                nmap[ny][nx + 1] = map[ny][nx];
	                nx++;
	            }
	            //상하로 끝까지
	            if (idx == 0) {
	                while (ny > 0) {
	                    nmap[ny - 1][nx] = map[ny][nx];
	                    ny--;
	                }
	            } else {
	                while (ny < r - 1) {
	                    nmap[ny + 1][nx] = map[ny][nx];
	                    ny++;
	                }
	            }
	            //좌측으로 끝까지
	            while (nx > 0) {
	                nmap[ny][nx - 1] = map[ny][nx];
	                nx--;
	            }
	            //공기청정기 위치 전까지
	            if (idx == 0) {
	                while (ny < curr.r - 1) {
	                    nmap[ny + 1][nx] = map[ny][nx];
	                    ny++;
	                }
	            } else {
	                while (ny > curr.r + 1) {
	                    nmap[ny - 1][nx] = map[ny][nx];
	                    ny--;
	                }
	            }
	        }
//	        cleanerCopy(nmap);
	    }
	 
	    public static void spreadCopy(int[][] nmap) {
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
	                map[i][j] = nmap[i][j];
	            }
	        }
	    }
	 
	    public static void cleanerCopy(int[][] nmap) {
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
	                if (i == 0 || i == r - 1 || j == 0 || j == c - 1 || i == cleaner_pos[0].r || i == cleaner_pos[1].r) {
	                    map[i][j] = nmap[i][j];
	                }
	            }
	        }
	        map[cleaner_pos[0].r][cleaner_pos[0].c] = -1;
	        map[cleaner_pos[1].r][cleaner_pos[1].c] = -1;
	    }
	 
	    public static void getAns() {
	        int ans = 0;
	        for (int i = 0; i < r; i++) {
	            for (int j = 0; j < c; j++) {
	                if (map[i][j] <= 0) continue;
	                ans += map[i][j];
	            }
	        }
	        System.out.println(ans);
	    }
	 
	    public static class Cleaner {
	        int r, c;
	 
	        public Cleaner(int r, int c) {
	            this.r = r;
	            this.c = c;
	        }
	    }
}

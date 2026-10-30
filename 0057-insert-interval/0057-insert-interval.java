class Solution {
    public int[][] insert(int[][] in, int[] newI) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = in.length;
        int i = 0;

        while (i < n && (in[i][1] < newI[0])) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(in[i][0]);
            temp.add(in[i][1]);
            ans.add(temp);
            i++;
        }
        if (i < n && in[i][0] > newI[1]) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(newI[0]);
            temp.add(newI[1]);
            ans.add(temp);
            while (i < n) {
                ArrayList<Integer> temp1 = new ArrayList<>();
                temp1.add(in[i][0]);
                temp1.add(in[i][1]);
                ans.add(temp1);
                i++;
            }
            int[][] temp2 = new int[ans.size()][2];
            for (int j = 0; j < ans.size(); j++) {
                temp2[j][0] = ans.get(j).get(0);
                temp2[j][1] = ans.get(j).get(1);
            }
            return temp2;
        }

        if (i == n) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(newI[0]);
            temp.add(newI[1]);
            ans.add(temp);
            int[][] temp2 = new int[ans.size()][2];
            for (int j = 0; j < ans.size(); j++) {
                temp2[j][0] = ans.get(j).get(0);
                temp2[j][1] = ans.get(j).get(1);
            }
            return temp2;
        }

        int st = Math.min(newI[0], in[i][0]);
        int end = Math.max(newI[1], in[i][1]);
        i++;
        while (i < n && (in[i][0] <= end)) {
            st = Math.min(st, in[i][0]);
            end = Math.max(end, in[i][1]);
            i++;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(st);
        temp.add(end);
        ans.add(temp);

        while (i < n) {
            ArrayList<Integer> temp1 = new ArrayList<>();
            temp1.add(in[i][0]);
            temp1.add(in[i][1]);
            ans.add(temp1);
            i++;
        }

        int[][] temp2 = new int[ans.size()][2];
        for (int j = 0; j < ans.size(); j++) {
            temp2[j][0] = ans.get(j).get(0);
            temp2[j][1] = ans.get(j).get(1);
        }
        return temp2;
    }
}
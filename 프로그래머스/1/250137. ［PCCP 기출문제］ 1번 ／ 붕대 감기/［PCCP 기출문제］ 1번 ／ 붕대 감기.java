class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int maxDuration = bandage[0];
        int heal = bandage[1];
        int bonus = bandage[2];
        
        int time = attacks[attacks.length - 1][0];
        int now = 0;
        for (int i = 0; i < attacks.length; i++) {
            int duration = 0;
            while (++now < attacks[i][0]) {
                health = health + heal >= maxHealth ? maxHealth : health + heal;
                duration++;
                if (duration == maxDuration) {
                    health = health + bonus >= maxHealth ? maxHealth : health + bonus;
                    duration = 0;
                }
            }
             if (now == attacks[i][0]) {
                health -= attacks[i][1];
                if (health <= 0)
                    return -1;
                duration = 0;
            }
        }
        return health;
    }
}
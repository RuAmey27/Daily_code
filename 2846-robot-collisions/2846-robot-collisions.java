class Solution {
        class Robot {
        int index;
        int position;
        int health;
        char direction;

        Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];

        // Create Robot objects with index for sorting result later
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }

        // Sort robots by position
        Arrays.sort(robots, (a, b) -> a.position - b.position);

        Stack<Robot> stack = new Stack<>();

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {  // robot.direction == 'L'
                while (!stack.isEmpty() && stack.peek().direction == 'R' && robot.health > 0) {
                    Robot rightRobot = stack.peek();
                    if (rightRobot.health < robot.health) {
                        stack.pop();
                        robot.health -= 1;
                    } else if (rightRobot.health > robot.health) {
                        rightRobot.health -= 1;
                        robot.health = 0;
                    } else {
                        stack.pop();
                        robot.health = 0;
                    }
                }
                if (robot.health > 0) {
                    stack.push(robot);
                }
            }
        }

        // Create a list to store healths of surviving robots in original order
        int[] resultHealths = new int[n];
        Arrays.fill(resultHealths, -1);

        for (Robot robot : stack) {
            resultHealths[robot.index] = robot.health;
        }

        List<Integer> survivors = new ArrayList<>();
        for (int health : resultHealths) {
            if (health != -1) {
                survivors.add(health);
            }
        }

        return survivors;
    }
    
}
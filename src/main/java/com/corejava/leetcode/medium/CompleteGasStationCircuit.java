package com.corejava.leetcode.medium;

public class CompleteGasStationCircuit {

    public static void main(String[] args) {
       // int gas[] = {1,2,3,4,5}, cost[] = {3,4,5,1,2};
        //int gas[] = {2,3,4}, cost[] = {3,4,3};
        int gas[] = {5,1,2,3,4}, cost[] = {4,4,1,5,1};

        CompleteGasStationCircuit stationCircuit =  new CompleteGasStationCircuit();
        System.out.println( "CurrentStation = " +stationCircuit.canCompleteCircuit(gas,cost));
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int numOfStations = gas.length;
        boolean isComplete = false;
        /*
            n == gas.length == cost.length
            1 <= n <= 105
            0 <= gas[i], cost[i] <= 104
         */
        //
        for(int currentStation = 0; currentStation < numOfStations; currentStation++) {
            if(gas[currentStation] > cost[currentStation]) {
                isComplete = false;
                int gassInTank = gas[currentStation];
                for (int nextStation = currentStation + 1, costToReach = currentStation; nextStation > -1; ) {
                    if (nextStation >= numOfStations) {
                        nextStation = 0;
                    }
                    if (costToReach >= numOfStations) {
                        costToReach = 0;
                    }
                    if (gassInTank >= cost[costToReach]) {
                        gassInTank = gassInTank - cost[costToReach++] + gas[nextStation++];
                        if (nextStation == currentStation) {
                            isComplete = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (isComplete) {
                    int index = currentStation - 1;
                    if (currentStation == 0) {
                        index = numOfStations - 1;
                    }
                    if (gassInTank >= cost[index]) {
                        return currentStation;
                    }
                }
            }
        }
        return -1;
    }

    public int canCompleteCircuitAccepted(int[] gas, int[] cost) {
        int sGas = 0, sCost = 0, res = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            sGas += gas[i];
            sCost += cost[i];
        }
        if (sGas < sCost) return -1;

        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }
}

/*
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique



Example 1:

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.


Constraints:

n == gas.length == cost.length
1 <= n <= 105
0 <= gas[i], cost[i] <= 104
 */

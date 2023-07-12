#include <iostream>
using namespace std;
int main()
{
    int node;
    char nodename[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    cout << "Enter the number of nodes:\n";
    cin >> node;
    int nodeTracker[node][node];
    for (int i = 0; i < node; i++)
    {
        for (int j = 0; j < node; j++)
        {
            nodeTracker[i][j] = 1000;
        }
    }
    int cost[node][node], temp[node], edgeCost;
    cout << "Enter costs of immediate neighbour for each node\n";
    for (int i = 0; i < node; i++)
    {
        cout << "For node " << i + 1 << endl;
        for (int j = 0; j < node; j++)
        {
            cin >> cost[i][j];
        }
    }
    for (int myNodes = 0; myNodes < node; myNodes++)
    {
        for (int i = 0; i < node; i++)
        {
            if (myNodes != i)
            {
                edgeCost = cost[i][myNodes];
            }
            else
            {
                edgeCost = 1111;
            }
            if (edgeCost < 1000)
            {
                for (int j = 0; j < node; j++)
                {
                    temp[j] = cost[i][j] + edgeCost;
                }

                CN Lab Manual TE COMP, Sem - I, 2021 - 22

                                                    Department of Computer Engineering,
                    MMCOE for (int k = 0; k < node; k++)
                {
                    if (cost[myNodes][k] <= temp[k])
                    {
                        cost[myNodes][k] = cost[myNodes][k];
                    }
                    else
                    {
                        cost[myNodes][k] = temp[k];
                        nodeTracker[myNodes][k] = i;
                    }
                }
            }
        }
    }
    cout << "____________________________" << endl;
    cout << "Shortest Distance" << endl;
    cout << "____________________________" << endl;
    for (int i = 0; i < node; i++)
    {
        cout << "For each " << i + 1 << endl
             << endl;
        cout << "TO Cost Next " << endl
             << endl;
        for (int j = 0; j < node; j++)
        {
            cout << nodename[j] << " ";
            cout << cost[i][j] << " ";
            int tempNum = nodeTracker[i][j];
            if (tempNum < 26)
            {
                cout << nodename[tempNum] << endl;
            }
            else
            {
                cout << "-" << endl;
            }
        }
        cout << endl;
    }
}
#include <iostream>

using namespace std;

const int row = 5, col = 5;

int test[row][col] = { 12, 23, 45, 54, 35,
				       53, 51, 23 ,31, 71,
				       72 ,61, 37, 68, 81,
				       65, 27, 89, 92, 75,
				       17, 76, 32, 45, 64};

int gettotal(const int test[][col], int row);
int getAverage(const int test[][col], int row);
int getRowTotal(const int test[][col], int row);
int getColumnTotal(const int test[][col], int row);
int getHighestInRow(const int test[][col], int row);
int getLowestInRow(const int test[][col], int row);

int gettotal(const int test[][col], int row)
{
	int count = 0, column, total = 0;
	for (count = 0; count < row; count++)
	{
		for (column = 0; column < col; column++)
			total += test[count][column];
	}
	return total;
}

int getAverage(const int test[][col], int row)
{
	int Average;
	Average = gettotal(test, row) / (row * col);
	return Average;
}

int getRowTotal(const int test[][col], int row)
{
	int rowtotal = 0, count, row_set;
	cout << "Which row's total do you want to know? : ";
	cin >> row_set;
	for (count = 0; count < col; count++)
	{
		rowtotal += test[row_set-1][count];
	}
	return rowtotal;
}

int getColumnTotal(const int test[][col], int row)
{
	int columntotal = 0, count,col_set;
	cout << "Which column's total do you want to know? : ";
	cin >> col_set;
	for (count = 0; count < row; count++)
	{
		columntotal += test[count][col_set -1];
	}
	return columntotal;
}
int getHighestInRow(const int test[][col], int row)
{
	int highest = 0, count, high_row;
	cout << "Which row's highest number do you want to know? : ";
	cin >> high_row;
	for (count = 0; count < col; count++)
	{
		if (highest < test[high_row -1][count])
			highest = test[high_row -1][count];
	}
	return highest;
}

int getLowestInRow(const int test[][col], int row)
{
	int lowest, count, low_row;
	cout << "Which row's lowest number do you want to know? : ";
	cin >> low_row;
	lowest = test[low_row - 1][0];
	for (count = 0; count < col; count++)
	{
		if (lowest > test[low_row -1][count])
			lowest = test[low_row -1][count];
	}
	return lowest;
}


int main()
{
	int total, row_total, column_total, highest_row, lowest_row, total_average;
	total = gettotal(test, 5);
	total_average = getAverage(test, 5);
	column_total = getColumnTotal(test, 5);
	row_total = getRowTotal(test, 5);
	highest_row = getHighestInRow(test, 5);
	lowest_row = getLowestInRow(test, 5);

	cout << "Your array's total is : " << total << endl;
	cout << "Your array's total Average is : " << total_average << endl;
	cout << "Your column total is : " << column_total << endl;
	cout << "Your row total is : " << row_total << endl;
	cout << "Highest number in your row is : " << highest_row << endl;
	cout << "Lowest number in your row is : " << lowest_row << endl;

	system("pause");
	return 0;
}

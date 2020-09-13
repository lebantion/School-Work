#include <iostream>

using namespace std;

const int monkey = 3, days = 7;

int Business[monkey][days] = { 4, 3, 5, 7, 2 ,4 , 6,
							   2, 1, 6, 2 ,4 ,5 , 7,
							   3, 6, 2, 1, 8, 9 , 6, };

int Average(const int array[][days], int num);
int least(const int array[][days], int num);
int greatest(const int array[][days], int num);

int Average(const int array[][days], int num)
{
	int count = 0, average = 0, total = 0, row;

	for (row = 0; row < num; row++)
	{
		for (count = 0; count < days; count++)
		{
			total += array[row][count];
		}
	}
	average = total / (monkey * days);
	return average;
}

int least(const int array[][days], int num)
{
	int number, count, lowest;
	cout << "which monkey's least amount do you want to know? : ";
	cin >> number;
	lowest = array[number-1][0];
	for (count = 0; count < days; count++)
	{
		if (lowest > array[number-1][count])
			lowest = array[number-1][count];
	}
	return lowest;
}

int greatest(const int array[][days], int num)
{
	int number, count, highest;
	cout << "which monkey's greatest amount do you want to know? : ";
	cin >> number;
	highest = array[number-1][0];
	for (count = 0; count < days; count++)
	{
		if (highest < array[number-1][count])
			highest = array[number-1][count];
	}
	return highest;
}

int main()
{
	cout << "That Monkey's least number is : " << least(Business, monkey) << endl;
	cout << "That Monkey's greatest number is : " << greatest(Business, monkey) << endl;
	cout << "Monkeys' total average per day is : " << Average(Business, monkey) << endl;
	
	system("pause");
	return 0;
	
}
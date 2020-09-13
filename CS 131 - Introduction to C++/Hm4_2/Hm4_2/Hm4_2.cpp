#include <iostream>

using namespace std;

int main()
{
	int total_penny ,penny, day, days; // Define total penny, penny and day and days to use
	total_penny = 0;
	penny = 1;

	cout << "How many days do you want to work? : ";
	cin >> days; // ask user to input day

	for (day = 1; day < days; day++) // will calculate until the day which user want to calculate
	{
		cout << day << " day," << " You get this much dollar : " << penny * 0.01 << endl;
		total_penny += penny; // add amount per day
		penny *= 2; // double the penny per day
	}
	
	cout << "Your total dollar is : " << total_penny * 0.01 << endl;

	system("pause");
	return 0;
}
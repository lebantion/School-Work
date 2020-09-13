#include <iostream>

using namespace std;

void getJudgeData(double &, double &, double &, double &, double &);
double calcScore(double, double, double, double, double);
double findLowest(double, double, double, double, double);
double findHighest(double, double, double, double, double);

int main()
{
	double score1, score2, score3, score4, score5;

	getJudgeData(score1, score2, score3, score4, score5);

	calcScore(score1, score2, score3, score4, score5);

	system("pause");
	return 0;

}

void getJudgeData(double &num1, double &num2, double &num3, double &num4, double &num5) // get Judge's Scores
{
	cout << "Enter #1 score : " << endl;
	cin >> num1;
	cout << "Enter #2 score : " << endl;
	cin >> num2;
	cout << "Enter #3 score : " << endl;
	cin >> num3;
	cout << "Enter #4 score : " << endl;
	cin >> num4;
	cout << "Enter #5 score : " << endl;
	cin >> num5;

	while (num1 < 0 || num2 < 0 || num3 < 0 || num4 < 0 || num5 < 0 || num1 > 10 || num2 > 10 || num3 > 10 || num4 > 10 || num5 > 10) // make sure that user put value which is between 0 to 10
	{
		cout << "Please, Enter the number which is between 0 to 10..." << endl;
		cout << "Enter #1 score : " << endl;
		cin >> num1;
		cout << "Enter #2 score : " << endl;
		cin >> num2;
		cout << "Enter #3 score : " << endl;
		cin >> num3;
		cout << "Enter #4 score : " << endl;
		cin >> num4;
		cout << "Enter #5 score : " << endl;
		cin >> num5;
	}
}
double calcScore(double num1, double num2, double num3, double num4, double num5) // calculate average Score which is dropped lowest and highest
{
		double total, dropped_total, average;
		total = num1 + num2 + num3 + num4 + num5;
		dropped_total = total - findLowest(num1, num2, num3, num4, num5) - findHighest(num1, num2, num3, num4, num5);
		average = dropped_total / 3;
		cout << "The average score is : " << average << endl;

		return average;
}

double findLowest(double num1, double num2, double num3, double num4, double num5) // get Lowest Score
{
	double lowest;
	if (num1 < num2 && num1 < num3 && num1 < num4 && num1 < num5)
		lowest = num1;
	else if (num2 < num1 && num2 < num3 && num2 < num4 && num2 < num5)
		lowest = num2;
	else if (num3 < num1 && num3 < num2 && num3 < num4 && num3 < num5)
		lowest = num3;
	else if (num4 < num1 && num4 < num2 && num4 < num3 && num4 < num5)
		lowest = num4;
	else if (num5 < num1 && num5 < num2 && num5 < num3 && num5 < num4)
		lowest = num5;
		
	return lowest;
}

double findHighest(double num1, double num2, double num3, double num4, double num5) // get highest Score
{
	double highest;
	if (num1 > num2 && num1 > num3 && num1 > num4 && num1 > num5)
		highest = num1;
	else if (num2 > num1 && num2 > num3 && num2 > num4 && num2 > num5)
		highest = num2;
	else if (num3 > num1 && num3 > num2 && num3 > num4 && num3 > num5)
		highest = num3;
	else if (num4 > num1 && num4 > num2 && num4 > num3 && num4 > num5)
		highest = num4;
	else if (num5 > num1 && num5 > num2 && num5 > num3 && num5 > num4)
		highest = num5;

	return highest;

}
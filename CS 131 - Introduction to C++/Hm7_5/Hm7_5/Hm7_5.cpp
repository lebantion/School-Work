#include <iostream>

using namespace std;
int ascending_func(int[], int);
void cal_average(int[], int);

int main()
{
	int *score, num_scores, sorts_exchange;
	
	cout << "How many Scores do you have? :";
	cin >> num_scores;

	score = new int[num_scores];
	
	for (int count = 0; count < num_scores; count++)
	{
		cout << "Please, Enter the the score of # " << count + 1 << " Test : ";
		cin >> score[count];
	}

	sorts_exchange = ascending_func(score, num_scores);

	cal_average(score, num_scores);

	system("pause");
	return 0;
}

int ascending_func(int values[], int size)
{
	bool swap;
	long temp;
	int  exchanges = 0;

	do
	{
		swap = false;

		for (int count = 0; count < (size - 1); count++)
		{
			if (values[count] > values[count + 1])
			{
				temp = values[count];
				values[count] = values[count + 1];
				values[count + 1] = temp;
				swap = true;
				exchanges++;
			}
		}

	} while (swap); 

	return exchanges;
}

void cal_average(int array[], int size)
{
	double total, average;
	total = 0;
	for (int count = 0; count < size; count++)
	{
		total += array[count];
	}
	average = total / size;

	cout << "Your Score's Average is : " << average << endl;
}
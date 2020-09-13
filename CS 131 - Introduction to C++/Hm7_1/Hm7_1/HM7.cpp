#include <iostream>

using namespace std;

const int SIZE = 5;
int fucn1[SIZE] = { 1, 2, 3, 4, 5 };
void fucn_copy(int[SIZE]);

int main()
{
	fucn_copy(fucn1);

	system("pause");
	return 0;
}

void fucn_copy(int array[SIZE])
{
	int *ptr = nullptr;

	ptr = new int[SIZE];

	for (int count = 0; count < SIZE; count++)
	{
		ptr[count] = array[count];
	}

}
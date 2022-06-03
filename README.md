# Втора лабораториска вежба по Софтверско инженерство

## Филип Јованов, бр. на индекс 196092

### Кодот за function

```java
package org.finki.ukim.mk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SILab2 {

	public static List<String> function(List<String> list) {
		if (list.size() <= 0) {
			throw new IllegalArgumentException("List length should be greater than 0");
		}
		int n = list.size();
		int rootOfN = (int) Math.sqrt(n);
		if (rootOfN * rootOfN != n) {
			throw new IllegalArgumentException("List length should be a perfect square");
		}
		List<String> numMines = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!list.get(i).equals("#")) {
				int num = 0;
				if ((i % rootOfN != 0 && list.get(i - 1).equals("#")) || (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#"))) {
					if ((i % rootOfN != 0 && list.get(i - 1).equals("#")) && (i % rootOfN != rootOfN - 1 && list.get(i + 1).equals("#"))) {
						num += 2;
					} else {
						num += 1;
					}
				}
				if (i - rootOfN >= 0 && list.get(i - rootOfN).equals("#")) {
					num++;
				}
				if (i + rootOfN < n && list.get(i + rootOfN).equals("#")) {
					num++;
				}
				numMines.add(String.valueOf(num));
			} else {
				numMines.add(list.get(i));
			}
		}
		return numMines;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		List<String> data = Arrays.stream(input.split(" ")).collect(Collectors.toList());
		List<String> output = function(data);

		System.out.println(output);
	}
}

```

### Control Flow Graph

![CFG](./CFG.drawio.png?raw=true "Control Flow Graph")

### Цикломатска комплексност

Цикломатската комплексност ја добив на два начини, првиот е преку следење на туторијалот најден
тука https://www.theserverside.com/feature/How-to-calculate-McCabe-cyclomatic-complexity-in-Java притоа имплементирајќи
ги истите правила, вториот е преку користење на Control Flow Diagram-от и броење на nodes-от и edges-от, и потоа нивна
искористување во формулата M = E - N + 2P. Крајниот резултат до кој дојдов е 18.

### Every Statement criteria

[Every Statement Table](every-statement.png?raw=true "Every Statement Criteria")

### Every Branch criteria

[Every Branch Table](every-branch.png?raw=true "Every Branch Criteria")
package asaad;

import java.util.*;
import java.util.stream.Collectors;

public class PatienceSorting {
	private final List<Card> cards;
	private final List<Stack<Card>> stacks = new ArrayList<>();
	private final PriorityQueue<Stack<Card>> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.peek().num));


	public PatienceSorting(List<Card> cards) {
		this.cards = cards;
		dealCards();
	}


	public List<Card> sort() {
		List<Stack<Card>> stacks = new ArrayList<>(this.stacks.size());
		for (Stack<Card> stack : this.stacks){
			Object clonedStack = stack.clone();
			stacks.add((Stack<Card>)clonedStack);
		}

		List<Card> answer = new ArrayList<>();
		heap.addAll(stacks);
		while (!heap.isEmpty()) {
			Stack<Card> card = heap.poll();
			answer.add(card.pop());
			if (!card.isEmpty())
				heap.add(card);
		}

		return answer;
	}

	private void dealCards() {
		for (Card card : cards) {
			int val = card.num;
			int k = binary_search(val);
			addToStack(k, card);
		}

	}

	private void addToStack(int k, Card card) {
		if (k == stacks.size())
			stacks.add(new Stack<>());
		stacks.get(k).add(card);
		if (k > 0)
			card.previous = stacks.get(k-1).peek();
	}

	public List<Integer> lis(){
		dealCards();
		List<Integer> longestIncreasingSub = new ArrayList<>(stacks.size());
		int k = stacks.size() - 1;
		Card ptr = stacks.get(k).peek();
		longestIncreasingSub.add(ptr.num);
		while (ptr.previous != null){
			ptr = ptr.previous;
			longestIncreasingSub.add(ptr.num);
		}

		Collections.reverse(longestIncreasingSub);

		return longestIncreasingSub;
	}

	private int binary_search(int target) {
		int n = stacks.size();
		int left = 0, right = n - 1, ans = n;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (stacks.get(mid).peek().num >= target) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return ans;
	}

}

package datastructure;

public class yzu1042065 {

	public yzu1042065() {

	}

	public static void main(String[] args) {
		NODE root;
		NODE p = new NODE(0);
		root = p;
		int i;
		for (i = 1; i <= 100; i++) {
			int ran = (int) (Math.random() * 100);
			insert(root, 0, ran);

		}
		show(root.pNext);

	}

//---------------------------------------
	static NODE find(NODE p, NODE t) {
		// 找到p，使得t.data<=p.pnext.data
		while (true) {
			if (p.pNext == null)
				break;
			
			if (p.pNext.data >= t.data)
				break;
		
			else if (p.pNext.data < t.data) {
				p = p.pNext;
			}
			
		}
		return p;
	}

	static NODE walkto(NODE root, int n) {
		NODE p = root;
		for (int i = 0; i < n; i++)
			p = p.pNext;
		return p;
	}

	static void delete(NODE root, int n) {
		NODE p = walkto(root, n);
		p.pNext = p.pNext.pNext;
	}

	static void insert(NODE root, int n, int d) {
		NODE p = walkto(root, n);
		NODE t = new NODE(d);
		p = find(p, t);
		// 把t放在p後面
		t.pNext = p.pNext;
		p.pNext = t;
	}

	static void show(NODE root) {
		NODE p = root;
		while (p != null) {
			System.out.print("(" + p.data + ")");
			p = p.pNext;
		}
		System.out.println();
	}

}

class NODE {
	NODE pNext;
	int data;

	NODE(int d) {
		data = d;
		pNext = null;
	}
}
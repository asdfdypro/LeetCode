package asdf.test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/**
	 * (两端对齐) Given an array of words and a length L, format the text such that
	 * each line has exactly L characters and is fully (left and right)
	 * justified.
	 * 
	 * You should pack your words in a greedy approach; that is, pack as many
	 * words as you can in each line. Pad extra spaces ' ' when necessary so
	 * that each line has exactly L characters.
	 * 
	 * Extra spaces between words should be distributed as evenly as possible.
	 * If the number of spaces on a line do not divide evenly between words, the
	 * empty slots on the left will be assigned more spaces than the slots on
	 * the right.
	 * 
	 * For the last line of text, it should be left justified and no extra space
	 * is inserted between words.
	 * 
	 * For example,
	 * 
	 * words: ["This", "is", "an", "example", "of", "text", "justification."]
	 * 
	 * L: 16.
	 * 
	 * Return the formatted lines as:
	 * 
	 * [
	 * 
	 * "This    is    an",
	 * 
	 * "example  of text",
	 * 
	 * "justification.  " ]
	 */
	//使用StringBuffer 速度一样

	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<String>();
		int from = 0, to = 0;// 起止位置
		int width = 0, spaceWidth = maxWidth;// 字符串长度,单词
		int len, spaces, emptyslots, w, i;
		StringBuffer line;
		while (to < words.length) {
			len = words[to].length();
			if (width + len > maxWidth) {
				w = to - from - 1;
				line = new StringBuffer(words[from]);

				if (w == 0) {// 仅有一个字符串
					from++;
					while (spaceWidth-- > 0)
						line.append(" ");
				} else {
					spaces = spaceWidth / w;
					emptyslots = spaceWidth % w;

					while (++from < to) {
						i = 0;
						while (i++ < spaces)
							line.append(" ");
						if (emptyslots-- > 0)
							line.append(" ");
						line.append(words[from]);
					}
				}
				res.add(line.toString());

				width = len + 1;// 空格
				spaceWidth = maxWidth - len;
				to++;
			} else {
				width += len + 1;// 空格
				spaceWidth -= len;
				to++;
			}
		}
		// 最后一行
		if (from < words.length) {
			emptyslots = spaceWidth - (to - from - 1);// 空格

			line = new StringBuffer(words[from]);
			while (++from < to) {
				line.append(" ");
				line.append(words[from]);
			}

			while (emptyslots-- > 0)
				line.append(" ");

			res.add(line.toString());
		}
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		// { "Th", "i", "an", "aa" };

		int maxWidth = 16;

		List<String> res = solution.fullJustify(words, maxWidth);
		for (String string : res) {
			System.out.println(string + "|");
		}
	}
}

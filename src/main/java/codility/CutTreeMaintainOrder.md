<p>
There are N trees growing along a street, each with a different height. 
For safety reasons, one of the trees needs to be cut down. 
The local council wants the street to look ordered, so all the other remaining trees should be sorted in non-decreasing order of height. 
Your goal is to count the number of ways this can be done.
</p>

<p>Write a function:</p>

<blockquote class="wp-block-quote">
<p>class Solution { public int solution(int[] A); }</p>
</blockquote>

<p>
that, given an array A consisting of N integers, where A[K] detonates the height of the K-th tree, 
returns the number of trees you can cut to satisfy above condition. 
If the condition cannot be satisfied, you should return 0.
</p>

<p>
<b>Examples</b>
</p>

<ol>

<li> 
Given A = [3,4,5,4] your function should return 2.
You can cut down the tree of height 5 or the tree of height 4.
</li>

<li> Given A = [4,5,2,3,4] your function should return 0. 
After cutting down any of these trees, the rest of the trees will not be ordered by height.
</li>

<li>Given A = [1,2,3,4,5,6,7] your function should return 7. You can cut down any of these trees.</li>
</ol>

<p>
Assume that:
</p>

<ul>
<li>N is an integer within range [1...200]</li>
<li>Each element of array A is an integer within range [1...1000]</li>
</ul>

<p>Focus on <b>correctness</b>. Performance of the solution is not the focus of this assignment.</p>
<div class="brinza-task-description">
<p>An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).</p>
<p>The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.</p>
<p>Write a function:</p>
<blockquote><p style="font-family: monospace; font-size: 9pt; display: block; white-space: pre-wrap"><tt>class Solution { public int[] solution(int[] A, int K); }</tt></p></blockquote>
<p>that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.</p>
<p>For example, given</p>
<tt style="white-space:pre-wrap">    A = [3, 8, 9, 7, 6]
    K = 3</tt>
<p>the function should return [9, 7, 6, 3, 8]. Three rotations were made:</p>
<tt style="white-space:pre-wrap">    [3, 8, 9, 7, 6] -&gt; [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -&gt; [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -&gt; [9, 7, 6, 3, 8]</tt>
<p>For another example, given</p>
<tt style="white-space:pre-wrap">    A = [0, 0, 0]
    K = 1</tt>
<p>the function should return [0, 0, 0]</p>
<p>Given</p>
<tt style="white-space:pre-wrap">    A = [1, 2, 3, 4]
    K = 4</tt>
<p>the function should return [1, 2, 3, 4]</p>
<p>Assume that:</p>
<blockquote><ul style="margin: 10px;padding: 0px;"><li>N and K are integers within the range [<span class="number">0</span>..<span class="number">100</span>];</li>
<li>each element of array A is an integer within the range [<span class="number">−1,000</span>..<span class="number">1,000</span>].</li>
</ul>
</blockquote><p>In your solution, focus on <b><b>correctness</b></b>. The performance of your solution will not be the focus of the assessment.</p>
</div>
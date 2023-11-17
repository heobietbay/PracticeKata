<div style="padding: 10px; border: solid 1pt #dddddd; background: #eeeeee;">
<h4>Question:</h4>
<p>A&nbsp;<em>binary gap</em>&nbsp;within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.</p>

<p>For example, number 9 has binary representation&nbsp;1001&nbsp;and contains a binary gap of length 2. The number 529 has binary representation&nbsp;1000010001&nbsp;and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation&nbsp;10100&nbsp;and contains one binary gap of length 1. The number 15 has binary representation&nbsp;1111&nbsp;and has no binary gaps. The number 32 has binary representation&nbsp;100000&nbsp;and has no binary gaps.</p>

<p>Write a function:</p>

<blockquote class="wp-block-quote">
<p>class Solution { public int solution(int N); }</p>
</blockquote>

<p>that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.</p>

<p>For example, given N = 1041 the function should return 5, because N has binary representation&nbsp;10000010001&nbsp;and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.</p>

<p>Write an&nbsp;<strong><strong>efficient</strong></strong>&nbsp;algorithm for the following assumptions:</p>

<blockquote class="wp-block-quote">
<ul>
	<li>N is an integer within the range [1..2,147,483,647].</li>
</ul>
</blockquote></div>
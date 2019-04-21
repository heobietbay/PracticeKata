package hackerrank.interviewpreparationkit.warmup;

/**
 *
 <pre>
 Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography.
 During his last hike he took exactly <b>n</b> steps.
 For every step he took, he noted if it was an uphill,<b>U</b>, or a downhill, <b>D</b>, step.
 Gary's hikes start and end at sea level and each step up or down represents a <b>1</b> unit change in altitude.
 We define the following terms:
 <li>A mountain is a sequence of consecutive steps above sea level,
 starting with a step up from sea level and ending with a step down to sea level.</li>

 <li>A valley is a sequence of consecutive steps below sea level,
 starting with a step down from sea level and ending with a step up to sea level.</li>

 <pre>Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
 For example, if Gary's path is
                                <code>s = |DDUUUUDD|</code>
 he first enters a <b>2</b> valley units deep. Then he climbs out an up onto a mountain <b>2</b> units high.
 Finally, he returns to sea level and ends his hike.

 <b>Function Description</b>

 Complete the countingValleys, it must return an integer that denotes the number of valleys Gary traversed.

 countingValleys has the following parameter(s):

 n: the number of steps Gary takes
 s: a string describing his path

 <b>Input Format</b>

 The first line contains an integer <b>n</b>, the number of steps in Gary's hike.
 The second line contains a single string <b>s</b>, of <b>n</b> characters that describe his path.

<b>Constraints</b>
   2 <= n <= 10^6
   s[i] in {UD}

<b>Output Format</b>

 Print a single integer that denotes the number of valleys Gary walked through during his hike.

<b>Sample Input</b>

 8
 UDDDUDUU

<b>Sample Output</b>

 1

<b>Explanation</b>

 If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:

 _/\       _
    \    /
     \/\/

 He enters and leaves one valley.
 </pre>

 </pre>
 */
public class CountingValleys {

    public static void main(String[] args) {

    }

    public static int solution (int n, char[] path)
    {
        return 0;
    }
}

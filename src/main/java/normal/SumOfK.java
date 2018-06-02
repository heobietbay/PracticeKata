package normal;

import java.util.List;

/**
 John and Mary want to travel between a few towns A, B, C ...
 Mary has on a sheet of paper a list of distances between these towns. <pre>ls = [50, 55, 57, 58, 60]. </pre>
 John is tired of driving and he says to Mary that he doesn't want to drive more than t = 174 miles and he will visit only 3 towns.

 Which distances, hence which towns, they will choose so that
 the sum of the distances is the biggest possible to please Mary - but less than t - to please John- ?

 <p>Example:</p>

 With list ls and 3 towns to visit they can make a choice between:
 <pre>[50,55,57],[50,55,58],[50,55,60],[50,57,58],[50,57,60],[50,58,60],[55,57,58],[55,57,60],[55,58,60],[57,58,60].</pre>

 The sums of distances are then: <pre>162, 163, 165, 165, 167, 168, 170, 172, 173, 175.</pre>

 The biggest possible sum taking a limit of <b>174</b> into account is then <font color='blue'>173</font>
 and the distances of the 3 corresponding towns is <pre>[55, 58, 60].</pre>

 The function <i><b>chooseBestSum</b></i> (or choose_best_sum or ... depending on the language)
 will take as parameters
 <li><font color='blue'><b>t</b></font> (maximum sum of distances, integer >= 0), </li>
 <li><font color='blue'><b>k</b></font> (number of towns to visit, k >= 1) and </li>
 <li><font color='blue'><b>ls</b></font> (list of distances, all distances are positive or null integers and this list has at least one element).</li>

 The function returns the "best" sum ie the biggest possible sum of <font color='blue'><b>k</b></font> distances
 less than or equal to the given limit <font color='blue'><b>t</b></font>, if that sum exists,
 or otherwise <i>nil, null, None, Nothing</i>, depending on the language. With C++, C, Rust, Swift, Go, Kotlin return -1.

 <p>Examples:</p>

     <pre>ts = [50, 55, 56, 57, 58] choose_best_sum(163, 3, ts) -> 163</pre>
     <pre>xs = [50] choose_best_sum(163, 3, xs) -> nil (or null or ... or -1 (C++, C, Rust, Swift, Go)</pre>
     <pre>ys = [91, 74, 73, 85, 73, 81, 87] choose_best_sum(230, 3, ys) -> 228 </pre>
 */
public class SumOfK {

    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        // your code
        return null;
    }
}
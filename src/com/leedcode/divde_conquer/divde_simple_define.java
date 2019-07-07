/**
 * 分治法： 将大问题转换为多个小问题，最后算小问题的结果集合。
 * （类似于分布式的 map-reduce）
 */

class solution {
    public result divide_conquer(problem, param1, parma2...) {

        // recursion terminator
        if problem == null {
            print_result;
            return
        }

        // prepare data
        data = prepare_data(problem)
        subProblems = split_problem(problem, data)

        // conquer subProblems
        subResult1 = divide_conquer(subProblems[0], p1, ...);
        subResult2 = divide_conquer(subProblems[1], p1, ...);
        subResult3 = divide_conquer(subProblems[2], p1, ...);
        ...

        result = process_result(subResult1, subResult2, subResult3, ...);
    }
}
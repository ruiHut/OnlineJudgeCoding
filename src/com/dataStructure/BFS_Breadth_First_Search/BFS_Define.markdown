### 广度优先搜索 BFS
符合人类思维，适应 queue
1. 速度更快 像一个网络，步骤较少不需要回退。
根据应用前景，添加 visited 结构。

#### 定义：Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'search key'[1]), and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.

### PseudoCode
```
  def BFS(graph, start, end):

    queue = []              // 定义一个保存节点状态的数据结构（queue 、array。。。）
    queue.append([start])   // 将起始节点加入 queue
    visited.add(start)      // 设为以访问  （visited 为节点 set 集合，用来保存所有被访问过的节点）

    while queue:            // 只要 queue 不为空
        node = quue.pop()   // 弹出最早进入的节点
        visited.add(node)

        process(node)       // 对 node 进行一系列操作
        // 两件事情
        // 1. 得到当前节点的所有后续节点，例如 “树” -> 子节点 、“图” -> 邻节点
        // 2. 判断是否 visited ? 舍弃 ：保存返回
        nodes = generate_related_nodeds(node)  
        queue.push(nodes) // 将返回回来的后续节点全部加入 queue 中 
```


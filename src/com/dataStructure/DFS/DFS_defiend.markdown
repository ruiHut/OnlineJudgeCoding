### 深度优先 DFS
符合计算机思维，由于计算机常用 stack
1. 代码编写容易
2. 对于需要回退的情景
根据应用前景，添加 visited 结构。

#### 定义：
### PseudoCode
```
    // 递归版本
    visited = set()
    def DFS(node, visited):
        visited.add(node)
        // process cur node here

        ... 
        for next_node in node.children():
            if not next_node in visited:
                DFS(next_node, visited)

    // 非递归版本 类似于 BFS
    def DFS(self, tree):
        if tree.root is None:
            return []

        visited, statck = [], [tree.root]

        while stack:
            node = stack.pop()
            visited.add(node)

            process(node)
            nodes = generate_related_nodes(node)
            stack.push(nodes)
        
        // other processing work
        ...
```


package com.mg.empty.demo.alt.data;

/**
 * 任意节点可以随意关联
 * 顶点  图中的数据元素  v（G）
 * 边    图中链接这些顶点的线  E(G)
 * 图可以分为  无向图 和 有向图
 *
 * 度  连接顶点的边数
 *
 * 无向完全图  无向图中每两个顶点之间都存在一条线
 * 有向完全图
 * 路径 两个顶点之间的连线
 *
 * 连通图  无向图中任意两个顶点都是联通的
 * 连通分量 无向图的最大联通子图
 *
 * 强连通图  有向图中任意两个顶点都是连通的
 * 强联通分量  有向图中最大联通子图
 *
 * 权  边表示的数值
 * 无向图中 加入权值 称为无向带权图
 * 有向图中加入权值  称为 有向带权图
 */
public class Graph {

    char[] vertex = new char[Integer.MAX_VALUE];
    int[][] edgeWeight = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];
    int[][] edge = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];

}

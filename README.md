# 1 介绍

Spike Commons项目, 作为原foundation项目的替代.

# 2 内容

	// commons项目
	├── commons
	├── commons-algorithm
	├── commons-io
	├── commons-lang
	├── commons-test
	├── commons-example
	├── dev-resources

	// commons-cloud项目
	├── commons-cloud								TODO 一些常见的依赖
	├── commons-cloud-client				服务客户端
	├── commons-cloud-common				cloud-common项目
	├── commons-cloud-configuration	配置服务器
	├── commons-cloud-server				服务注册服务器
	├── commons-cloud-service				服务实现

	服务器PORT:
	configuration 8888		commons-cloud-configuration/ConfigServer, commons-cloud-client/ConfigClient
	server 				8889		commons-cloud-server/NetflixServerApplication
	service 			8890		commons-cloud-service/NetflixServiceApplication
	client				8891		commons-cloud-client/NetflixClientApplication

	// TODO more specific
	├── algorithm	算法
	│   └── bean 数据结构
	│       ├── Permute
	│       ├── TOH
	│       ├── dictionary
	│       ├── externalsort
	│       │   ├── Exmrg1
	│       │   ├── Exmrg2
	│       │   └── Exmrg3
	│       ├── internalsort
	│       ├── list
	│       │   ├── array
	│       │   └── link
	│       ├── tree
	│       │   ├── btree
	│       │   ├── heap
	│       │   ├── huffman
	│       │   ├── regular
	│       │   └── separate
	│       └── util
	├── annotation 注解
	│   ├── comment
	│   ├── concurrency
	│   ├── designpattern
	│   ├── specification
	│   └── support
	├── example 示例
	│   └── designpattern
	│       └── support
	├── exception 异常
	├── file	文件
	├── fp 函数式
	├── lang Java lang
	└── simulation 模拟

# BookManagementSystem
### README.md

# 图书管理系统（Library Management System）

这个项目实现了一个简单的图书管理系统，支持管理员和用户两种角色。管理员可以管理书籍（添加、删除、查看书籍），而用户可以借书、还书，并查看所有书籍信息。

## 项目功能

### 管理员功能

1. **添加图书** - 管理员可以向系统中添加新的图书，需提供书名、作者、ISBN 和库存数量。
2. **删除图书** - 管理员可以根据书籍的 ISBN 删除图书。
3. **查看所有图书** - 管理员可以查看所有存储在系统中的图书信息。
4. **退出系统** - 管理员可以选择退出系统。

### 用户功能

1. **借书** - 用户可以借阅书籍，只需提供书籍的 ISBN。
2. **还书** - 用户可以归还借阅的书籍。
3. **查看所有图书** - 用户可以查看系统中所有书籍的信息。
4. **退出系统** - 用户可以选择退出系统。

## 项目结构

```
BookManagementSystem/
├── data/
│   ├── books.txt                # 存储图书信息的文件
│   └── admin_credentials.txt    # 存储管理员登录凭证的文件
├── src/
│   ├── Admin.java               # 管理员类，处理管理员相关功能
│   ├── Book.java                # 图书类，包含图书信息
│   ├── Library.java             # 图书馆类，管理所有图书
│   ├── User.java                # 用户类，处理用户的借书还书操作
│   ├── LoadingHelper.java       # 辅助类，模拟加载过程
│   └── Main.java                # 主类，程序入口，处理用户与管理员交互
└── README.md                    # 项目的说明文件
```

### 数据文件说明

- **`data/books.txt`**：保存所有图书信息的文本文件，格式如下：
  ```
  <书名>, <作者>, <ISBN>, <库存数量>
  ```
  例如：
  ```
  Java Programming, John Doe, 123456, 5
  Data Structures, Jane Smith, 654321, 3
  ```

- **`data/admin_credentials.txt`**：保存管理员登录凭证的文本文件，格式如下：
  ```
  <用户名>
  <密码>
  ```
  示例内容：
  ```
  admin
  123456
  ```

## 使用方法

### 1. 安装 JDK

- 请确保已经安装了 Java 开发工具包（JDK），并将 `javac` 和 `java` 命令添加到系统的 PATH 中。

### 2. 项目文件结构

假设你已经克隆了项目，并且文件结构如下：

```
BookManagementSystem/
├── data/
│   ├── books.txt
│   └── admin_credentials.txt
├── src/
│   ├── Admin.java
│   ├── Book.java
│   ├── Library.java
│   ├── User.java
│   ├── LoadingHelper.java
│   └── Main.java
```

确保 `data/books.txt` 和 `data/admin_credentials.txt` 文件存在，并且包含正确的数据。

### 3. 编译项目

打开命令行（CMD），进入项目的根目录，然后运行以下命令编译所有 Java 源文件：

```bash
javac -d bin src/*.java
```

这将会把所有的 `.java` 文件编译到 `bin` 文件夹中。

### 4. 运行项目

编译完成后，可以运行主类 `Main.java`，执行以下命令：

```bash
java -cp bin Main
```

### 5. 用户/管理员登录

- **管理员登录**：请输入正确的管理员用户名和密码（用户名：`wuyou`，密码：`007991`）。
- **用户登录**：用户可以直接进入系统，无需输入用户名和密码。

### 6. 操作流程

- 登录成功后，系统会根据角色（管理员或用户）显示不同的菜单选项。
- 管理员可以进行书籍的添加、删除和查看操作。
- 用户可以借阅和归还书籍，并查看所有图书。

### 7. 退出系统

在任何菜单中，输入选项 `4` 即可退出系统。

## 示例

### 启动后：

```
Welcome to the Library Management System!
Are you an Admin or User? (Enter 'admin' or 'user'): admin
Enter Admin Username: admin
Enter Admin Password: 123456
Loading...
Admin login successful!

Admin Menu:
1. Add Book
2. Remove Book
3. View All Books
4. Exit
Choose an option:
```

- 如果选择 `1`，管理员可以添加书籍。
- 如果选择 `3`，管理员可以查看所有图书。
- 如果选择 `4`，退出系统。

### 用户操作：

```
Welcome to the Library Management System!
Are you an Admin or User? (Enter 'admin' or 'user'): user

User Menu:
1. Borrow Book
2. Return Book
3. View All Books
4. Exit
Choose an option:
```

- 用户可以选择借书、还书或查看所有图书。

## 文件路径

- **books.txt** 和 **admin_credentials.txt** 文件位于 `data/` 文件夹内。如果文件不存在或路径错误，程序将无法正常运行。

## 依赖

- 无外部依赖，仅使用 Java 标准库。

## 贡献

欢迎提出问题、建议或提交 pull requests。如果您发现 bug 或有改进建议，请提交 issue 或 PR。

## 联系方式

- 作者：WU
- 电子邮件：Wuyou007991@outlook.com

---

# vue.js脚手架2.0 通用模板

## 前言
* 本模板是基于[https://github.com/PanJiaChen/vue-admin-template](https://github.com/PanJiaChen/vue-admin-template)模板改进
* [预览地址:https://panjiachen.github.io/vue-admin-template/](https://panjiachen.github.io/vue-admin-template/)
* 由于参照的模板中使用了大量的vuex和个人对项目结构的习惯方式不一样, 
  所以只是对项目结构和部分功能的实现方式进行了修改
* 模板中的数据都是hardcode的, 但已集成axios。 若需要集成后台api, 直接使用即可 

## 包含类库
  1. axios: 封装get、put、post、delete方法.
  2. router: 使用嵌套路由，包含公共头部、侧边栏、主内容三个部分
  3. vuex: 页面与页面间通信神器
  4. i18n: 国际化，根据浏览器的设置自动选择语言(控制台输入vue.$i18n.locale="es-US")
  5. 支持scss style格式


## 项目预览
* [链接: http://49.235.135.230/](http://49.235.135.230/)

## 多环境打包方法
* 项目的`environment`文件夹中有不同配置的配置文件, 包含: **dev, local, prod, qa**  
  若想打qa环境的包, 可将qa.js中的内容copy至index.js，再执行 **npm run build**命令即可  
  因为项目中统一使用的是`environment/index.js`中的配置, 并且vuecli 2.0默认打包时使用的  
  是`environment/index.js`中的配置。所以采取了**此种比较愚笨的不同环境打包方式**  

* 当然也可以使用 `cross-env`插件来解决使用不同命令打不同包的需求, 此模板中并未集成, 
  若想实现此功能可自行搜索相关知识

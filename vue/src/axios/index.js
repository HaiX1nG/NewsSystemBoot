import axios from "axios";

let config = {
    // 每次请求的协议, IP地址. 设置该配置后,每次请求路径都可以使用相对路径, 例如"/news/findAll"
    baseURL: 'http://localhost:9090/',
    // 请求超时时间
    timeout: 5000,
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    },
    // 每次请求是否携带cookie
    withCredentials: true
}
// 创建axios实例
const instance = axios.create(config)
// 导出axios实例
export default instance
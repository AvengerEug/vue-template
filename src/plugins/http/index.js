import axios from 'axios'
import env from '../../environment'

axios.baseURL = env.backendDomain

export default class HTTP {

    static get = (url, params) => {
        return new Promise((resolve, reject) => {
            const response = axios.get(url, params)
            if (response.status !== 200) {
                reject("请求失败: " + response.errorMessage)
            } else {
                resolve(response)
            }
        })
    }
}
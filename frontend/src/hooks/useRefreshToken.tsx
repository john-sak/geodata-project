import axios from '@/api/axios';

const useRefreshToken = () => {
  const refreshToken = localStorage.getItem('refresh_token');
  const refresh = async () => {
    try {
        const response = await axios.post('/api/refreshtoken', {refreshToken});
        console.log(response.data);
        localStorage.setItem('access_token', response.data.accessToken);
        localStorage.setItem('refresh_token', response.data.refreshToken);
        return response.data.accessToken;
    }
    catch(error) {
        console.error(error);
    }
  }
  return refresh;
}

export default useRefreshToken
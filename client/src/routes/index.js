import DefaultPage from "../pages/DefaultPage/DefaultPage";
import DownloadPage from "../pages/DownloadPage/DownloadPage";
import HomePage from "../pages/HomePage/HomePage";


export const routes = [
  {
    path: "/",
    element: <DefaultPage/>,
    children: [
      {path: "", element: <HomePage/>},
      {path: "/download-app",element: <DownloadPage/>}
    ]
  }
] 
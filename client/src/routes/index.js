import CoursePage from "../pages/CoursePage/CoursePage";
import DefaultPage from "../pages/DefaultPage/DefaultPage";
import DownloadPage from "../pages/DownloadPage/DownloadPage";
import HomePage from "../pages/HomePage/HomePage";
import LoginPage from "../pages/LoginPage/LoginPage";


export const routes = [
  {
    path: "/",
    element: <DefaultPage/>,
    children: [
      {path: "", element: <HomePage/>},
      {path: "/login",element: <LoginPage/>},
      {path: "/course",element: <CoursePage/>},
      {path: "/download-app",element: <DownloadPage/>}
    ]
  }
] 
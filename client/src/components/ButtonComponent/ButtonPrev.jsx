
export const CustomPrevArrow = (props) => {
    const { onClick,top,record } = props;
    return (
      <div
        className={`absolute z-10 ${record?`-left-${record}`:"left-2"} ${top?`top-${top}`:"top-1/2"} transform -translate-y-1/2 bg-gray-800 text-white p-4 rounded-full border border-third hover:bg-[#3e4143] cursor-pointer`}
        onClick={onClick}
      >
        <svg fill="#ffffff" height="14px" width="14px" version="1.1" viewBox="0 0 24 24" transform="matrix(-1, 0, 0, 1, 0, 0)" stroke="#ffffff"
        >
        <g strokeWidth="0"></g>
        <g strokeLinecap="round" strokeLinejoin="round"></g>
        <g>
            <g>
            <polygon points="6.8,23.7 5.4,22.3 15.7,12 5.4,1.7 6.8,0.3 18.5,12" />
            </g>
        </g>
        </svg>
      </div>
    );
  };
import dynamic from "next/dynamic";

const Search = dynamic(() => import('./Search'), {
    ssr: false
})

export default Search;
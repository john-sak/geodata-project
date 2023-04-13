import {useEffect, useRef} from 'react'

const useCloseModal = (handler: any) => {
    let ref = useRef<HTMLInputElement>(null);

    useEffect(() => {
      let event_handler = (event: any) => {
        if(!ref?.current?.contains(event.target as Node)) {
          handler();
        }
      };
  
      document.addEventListener("mousedown",event_handler);
  
      return() => {
        document.removeEventListener("mousedown",event_handler);
      };
    });
    return ref;
}

export default useCloseModal
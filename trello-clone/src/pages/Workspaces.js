import React, { useEffect, useState } from 'react';
import ViewWorkspaces from '../components/ViewWorkSpaces';

function Workspaces() {
    const [WorkspacesData, setWorkspacesData] = useState([]);

    function getAllWorkspaces() {
        fetch('http://localhost:3000/Workspaces')
            .then(response => response.json())
            .then(Workspaces => {
                setWorkspacesData(Workspaces);
            });
    };

    useEffect(function () {
        getAllWorkspaces();
    }, []);

    return (
        <section>
            <ViewWorkspaces Workspaces={WorkspacesData} />
        </section>
    );
};

export default Workspaces;
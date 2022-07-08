import React from 'react';
import { useHistory } from 'react-router-dom';
import CreateWorkspaceForm from '../components/forms/CreateWorkspaceForm';

function CreateWorkspace() {

    const history = useHistory();

    function createWorkspaceHandler(workspace) {
        fetch('http://localhost:9001/workspace', {
            method: 'POST',
            body: JSON.stringify(workspace),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(() => history.replace('/Workspace'));
    }

    return (
        <CreateWorkspaceForm createWorkspace={createWorkspaceHandler} />
    );
};

export default CreateWorkspace;